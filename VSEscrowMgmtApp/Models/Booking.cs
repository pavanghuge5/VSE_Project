using System;
using System.Collections.Generic;

namespace VSEscrowMgmtApp.Models;

public partial class Booking
{
    public int BookId { get; set; }

    public double? Amount { get; set; }

    public int? InterestId { get; set; }

    public DateOnly? Date { get; set; }

    public virtual Interest? Interest { get; set; }

    public virtual ICollection<Payment> Payments { get; set; } = new List<Payment>();
}
