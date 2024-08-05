using System;
using System.Collections.Generic;

namespace VSEscrowMgmtApp.Models;

public partial class SubCategory
{
    public int SubcatId { get; set; }

    public string? SubcatName { get; set; }

    public int? CatId { get; set; }

    public virtual Category? Cat { get; set; }
}
