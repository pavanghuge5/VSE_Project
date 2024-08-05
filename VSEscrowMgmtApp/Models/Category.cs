using System;
using System.Collections.Generic;

namespace VSEscrowMgmtApp.Models;

public partial class Category
{
    public int CatId { get; set; }

    public string? CatName { get; set; }

    public virtual ICollection<SubCategory> SubCategories { get; set; } = new List<SubCategory>();
}
