using System;
using System.Collections.Generic;

namespace EscrowApp.Models;

public partial class Payment
{
    public int PaymentId { get; set; }

    public int? BookId { get; set; }

    public DateTime? Date { get; set; }

    public double? Amount { get; set; }

    public virtual Booking? Book { get; set; }

    public virtual ICollection<Verification> Verifications { get; set; } = new List<Verification>();
}
