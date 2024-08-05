using System;
using System.Collections.Generic;

namespace VSEscrowMgmtApp.Models;

public partial class User
{

    public User()
    {
        Buyers = new HashSet<Buyer>();
        Sellers = new HashSet<Seller>();
    }

    public int Uid { get; set; }

    public string? Username { get; set; }

    public string? Password { get; set; }

    public int? Rid { get; set; }

    public virtual ICollection<Buyer>? Buyers { get; set; }

    public virtual Role? Role { get; set; } = null!;

    public virtual ICollection<Seller>? Sellers { get; set; }
}
