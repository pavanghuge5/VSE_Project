using Microsoft.AspNetCore.Cors;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
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
       public Seller SaveSeller (Seller seller)
        {
            using(var db = new VsescrowContext())
            {
                seller.User.Password = BCrypt.Net.BCrypt.HashPassword(seller.User.Password);
            db.Sellers.Add(seller);
                db.SaveChanges();
            }
            return seller;
        }

        [HttpPost]
        public User VerifyLogin(LoginModel login)
        {
            using(var db  = new VsescrowContext())
            {
                var user = db.Users.Include(u => u.Role).FirstOrDefault(u => login.Username == u.Username);
                if (user != null && BCrypt.Net.BCrypt.Verify(login.Password, user.Password)) {
                    return user;
                }
            }

            return null;
        }

        [HttpGet]
        public List<Buyer> GetBuyers()
        {
            List<Buyer> result = new List<Buyer>();
            using(var db = new VsescrowContext()) 
            { 
                result = db.Buyers.ToList(); 
            } 
            return result;   
        }

        [HttpPost]
        public Buyer SaveBuyer(Buyer buyer) 
        {
            using (var db = new VsescrowContext()) {
                buyer.User.Password = BCrypt.Net.BCrypt.HashPassword(buyer.User.Password);
                db.Buyers.Add(buyer);
                db.SaveChanges();
            }
            return buyer;
        }
    }
}
