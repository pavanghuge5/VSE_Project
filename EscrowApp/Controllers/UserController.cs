using EscrowApp.Models;
using Microsoft.AspNetCore.Cors;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System;
using VSEscrowMgmtApp.Models;

namespace VSEscrowMgmtApp.Controllers
{
    [Route("api/[controller]/[action]")]
    [EnableCors]
    [ApiController]
    public class UserController : ControllerBase
    {
        [HttpGet]
        public List<Seller> GetSellers()
        {
            List<Seller> result = new List<Seller>();
            using (var db = new VsescrowContext())
            {
                result = db.Sellers.ToList();
            }
            return result;
        }

        [HttpPost]
        public Seller SaveSeller(Seller seller)
        {
            using (var db = new VsescrowContext())
            {
                seller.User.Password = BCrypt.Net.BCrypt.HashPassword(seller.User.Password);
                seller.User.Rid = 1;
                db.Sellers.Add(seller);
                db.SaveChanges();
            }
            return seller;
        }

        [HttpGet("{userId}")]
        public ActionResult<Seller> GetSellerByUserId(int userId)
        {
            using (var db = new VsescrowContext())
            {
                var seller = db.Sellers
                    .Where(s => s.UserId == userId)
                    .Select(s => new Seller
                    {
                        Fname = s.Fname,
                        Lname = s.Lname
                    })
                    .FirstOrDefault();

                if (seller == null)
                {
                    return NotFound("No seller found with the given User ID.");
                }

                return Ok(seller);
            }
        }


        [HttpGet("{userId}")]
        public ActionResult<Buyer> GetBuyerByUserId(int userId)
        {
            using (var db = new VsescrowContext())
            {
                var buyer = db.Buyers
                    .Where(b => b.UserId == userId)
                    .Select(b => new Buyer
                    {
                        Fname = b.Fname,
                        Lname = b.Lname
                    })
                    .FirstOrDefault();

                if (buyer == null)
                {
                    return NotFound("No buyer found with the given User ID.");
                }

                return Ok(buyer);
            }
        }




        [HttpPost]
        public ActionResult<User> VerifyLogin(LoginModel login)
        {
            using (var db = new VsescrowContext())
            {
                var user = db.Users.Include(u => u.Role).FirstOrDefault(u => login.Username == u.Username);
                if (user != null && BCrypt.Net.BCrypt.Verify(login.Password, user.Password))
                {
                    return Ok(new { username = user.Username, rid = user.Rid });
                }
            }

            return Unauthorized();
        }

        [HttpGet("{username}")]
        public ActionResult CheckUsername(string username)
        {
            using (var db = new VsescrowContext())
            {
                var userExists = db.Users.Any(u => u.Username == username);
                if (userExists)
                {
                    return Ok(new { available = false });
                }
                return Ok(new { available = true });
            }
        }


        [HttpGet]
        public List<Buyer> GetBuyers()
        {
            List<Buyer> result = new List<Buyer>();
            using (var db = new VsescrowContext())
            {
                result = db.Buyers.ToList();
            }
            return result;
        }

        [HttpPost]
        public Buyer SaveBuyer(Buyer buyer)
        {
            using (var db = new VsescrowContext())
            {
                buyer.User.Password = BCrypt.Net.BCrypt.HashPassword(buyer.User.Password);

                buyer.User.Rid = 2;
                db.Buyers.Add(buyer);
                db.SaveChanges();
                Console.WriteLine($"RoleId: {buyer.User.Rid}");
            }
            return buyer;
        }
    }
}
