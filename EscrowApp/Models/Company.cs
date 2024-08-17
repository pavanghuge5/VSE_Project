using System;
using System.Collections.Generic;

namespace EscrowApp.Models;

public partial class Company
{
    public int ComId { get; set; }

    public string ComName { get; set; } = null!;

    public virtual ICollection<Model> Models { get; set; } = new List<Model>();

    public virtual ICollection<Vehicle> Vehicles { get; set; } = new List<Vehicle>();
}
