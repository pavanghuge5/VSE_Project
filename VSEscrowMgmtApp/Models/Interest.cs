using System;
using System.Collections.Generic;

namespace VSEscrowMgmtApp.Models;

public partial class Interest
{
    public int InterestId { get; set; }

    public int? VId { get; set; }

    public int? BId { get; set; }

    public virtual Buyer? BIdNavigation { get; set; }

    public virtual ICollection<Booking> Bookings { get; set; } = new List<Booking>();

    public virtual Vehicle? VIdNavigation { get; set; }
}
