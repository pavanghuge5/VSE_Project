using System;
using System.Collections.Generic;

namespace EscrowApp.Models;

public partial class Verification
{
    public int VerificationId { get; set; }

    public int? PaymentId { get; set; }

    public int? SId { get; set; }

    public int? BId { get; set; }

    public sbyte? BuyrConf { get; set; }

    public sbyte? SellrConf { get; set; }

    public sbyte? AdminConf { get; set; }

    public virtual Buyer? BIdNavigation { get; set; }

    public virtual Payment? Payment { get; set; }

    public virtual Seller? SIdNavigation { get; set; }
}
