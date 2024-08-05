using System;
using System.Collections.Generic;

namespace VSEscrowMgmtApp.Models;

public partial class Vehicle
{
    public int VId { get; set; }

    public string? VName { get; set; }

    public string? SId { get; set; }

    public string? ManufactrId { get; set; }

    public virtual ICollection<Interest> Interests { get; set; } = new List<Interest>();
}
