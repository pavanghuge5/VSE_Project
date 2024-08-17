using System;
using System.Collections.Generic;

namespace EscrowApp.Models;

public partial class Model
{
    public int ModelId { get; set; }

    public string? ModelName { get; set; }

    public int? ComId { get; set; }

    public virtual Company? Com { get; set; }

    public virtual ICollection<Vehicle> Vehicles { get; set; } = new List<Vehicle>();
}
