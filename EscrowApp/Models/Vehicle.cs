using System;
using System.Collections.Generic;

namespace EscrowApp.Models;

public partial class Vehicle
{
    public int VId { get; set; }

    public int? ModelId { get; set; }

    public int? SId { get; set; }

    public int? ComId { get; set; }

    public int? CatId { get; set; }

    public int? ScatId { get; set; }

    public string RegistrationYear { get; set; } = null!;

    public string? KmsDriven { get; set; }

    public string? FuelType { get; set; }

    public int? NoOfSeats { get; set; }

    public int? Ownership { get; set; }

    public string? Transmission { get; set; }

    public int? EngineCapacity { get; set; }

    public string? Rto { get; set; }

    public string? VImages { get; set; }

    public int? VPrice { get; set; }

    public virtual Category? Cat { get; set; }

    public virtual Company? Com { get; set; }

    public virtual ICollection<Interest> Interests { get; set; } = new List<Interest>();

    public virtual Model? ModelNavigation { get; set; }

    public virtual Seller? SIdNavigation { get; set; }

    public virtual SubCategory? Scat { get; set; }
}
