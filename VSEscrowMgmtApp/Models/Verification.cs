using System;
using System.Collections.Generic;

namespace VSEscrowMgmtApp.Models;

public partial class Verification
{
    public int? PaymentId { get; set; }

    public int? SId { get; set; }

    public int? BId { get; set; }

    public string? BuyrConf { get; set; }

    public string? SellrConf { get; set; }

    public virtual Buyer? BIdNavigation { get; set; }

    public virtual Payment? Payment { get; set; }

    public virtual Seller? SIdNavigation { get; set; }
}
