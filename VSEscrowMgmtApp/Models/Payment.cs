using System;
using System.Collections.Generic;

namespace VSEscrowMgmtApp.Models;

public partial class Payment
{
    public int PaymentId { get; set; }

    public int? BookId { get; set; }

    public DateOnly? Date { get; set; }

    public double? Amount { get; set; }

    public virtual Booking? Book { get; set; }
}
