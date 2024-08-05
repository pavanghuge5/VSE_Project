using System;
using System.Collections.Generic;

namespace VSEscrowMgmtApp.Models;

public partial class Buyer
{

    public Buyer()
    {
        Interests = new HashSet<Interest>();
    }

    public int BId { get; set; }

    public string? Fname { get; set; }

    public string? Lname { get; set; }

    public string? BContact { get; set; }

    public string? Address { get; set; }

    public string? BAccNo { get; set; }

    public string? BankName { get; set; }

    public string? IfscCode { get; set; }

    public int? UserId { get; set; }

    public virtual ICollection<Interest>? Interests { get; set; }

    public virtual User? User { get; set; }
}
