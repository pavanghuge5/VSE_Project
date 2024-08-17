using System;
using System.Collections.Generic;

namespace EscrowApp.Models;

public partial class Buyer
{
    public int BId { get; set; }

    public string? Fname { get; set; }

    public string? Lname { get; set; }

    public string? BContact { get; set; }

    public string? Address { get; set; }

    public string? BAccNo { get; set; }

    public string? BankName { get; set; }

    public string? IfscCode { get; set; }

    public int? UserId { get; set; }

    public virtual ICollection<Interest>? Interests { get; set; } = new List<Interest>();

    public virtual User? User { get; set; }

    public virtual ICollection<Verification>? Verifications { get; set; } = new List<Verification>();
}
