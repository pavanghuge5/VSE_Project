using System;
using System.Collections.Generic;

namespace VSEscrowMgmtApp.Models;

public partial class Seller
{
    public int SId { get; set; }

    public string? Fname { get; set; }

    public string? Lname { get; set; }

    public string? SContact { get; set; }

    public string? Address { get; set; }

    public string? SAccNo { get; set; }

    public string? BankName { get; set; }

    public string? IfscCode { get; set; }

    public int? UserId { get; set; }

    public virtual User? User { get; set; }
}
