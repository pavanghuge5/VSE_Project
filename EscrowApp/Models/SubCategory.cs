using System;
using System.Collections.Generic;

namespace EscrowApp.Models;

public partial class SubCategory
{
    public int SubcatId { get; set; }

    public string? SubcatName { get; set; }

    public int? CatId { get; set; }

    public virtual Category? Cat { get; set; }

    public virtual ICollection<Vehicle> Vehicles { get; set; } = new List<Vehicle>();
}
