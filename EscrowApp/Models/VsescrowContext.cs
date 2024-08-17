using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using Pomelo.EntityFrameworkCore.MySql.Scaffolding.Internal;

namespace EscrowApp.Models;

public partial class VsescrowContext : DbContext
{
    public VsescrowContext()
    {
    }

    public VsescrowContext(DbContextOptions<VsescrowContext> options)
        : base(options)
    {
    }

    public virtual DbSet<Booking> Bookings { get; set; }

    public virtual DbSet<Buyer> Buyers { get; set; }

    public virtual DbSet<Category> Categories { get; set; }

    public virtual DbSet<Company> Companies { get; set; }

    public virtual DbSet<Interest> Interests { get; set; }

    public virtual DbSet<Model> Models { get; set; }

    public virtual DbSet<Payment> Payments { get; set; }

    public virtual DbSet<Role> Roles { get; set; }

    public virtual DbSet<Seller> Sellers { get; set; }

    public virtual DbSet<SubCategory> SubCategories { get; set; }

    public virtual DbSet<User> Users { get; set; }

    public virtual DbSet<Vehicle> Vehicles { get; set; }

    public virtual DbSet<Verification> Verifications { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseMySql("server=localhost;port=3306;user=root;password=root;database=vsescrow", Microsoft.EntityFrameworkCore.ServerVersion.Parse("8.2.0-mysql"));

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder
            .UseCollation("utf8mb4_0900_ai_ci")
            .HasCharSet("utf8mb4");

        modelBuilder.Entity<Booking>(entity =>
        {
            entity.HasKey(e => e.BookId).HasName("PRIMARY");

            entity.ToTable("booking");

            entity.HasIndex(e => e.InterestId, "intrestid_idx");

            entity.Property(e => e.BookId).HasColumnName("book_id");
            entity.Property(e => e.Amount).HasColumnName("amount");
            entity.Property(e => e.Date)
                .HasColumnType("datetime")
                .HasColumnName("date");
            entity.Property(e => e.InterestId).HasColumnName("interest_id");

            entity.HasOne(d => d.Interest).WithMany(p => p.Bookings)
                .HasForeignKey(d => d.InterestId)
                .HasConstraintName("intrestid");
        });

        modelBuilder.Entity<Buyer>(entity =>
        {
            entity.HasKey(e => e.BId).HasName("PRIMARY");

            entity.ToTable("buyer");

            entity.HasIndex(e => e.BContact, "b_contact_UNIQUE").IsUnique();

            entity.HasIndex(e => e.UserId, "uid_fk_idx");

            entity.Property(e => e.BId).HasColumnName("b_id");
            entity.Property(e => e.Address)
                .HasMaxLength(45)
                .HasColumnName("address");
            entity.Property(e => e.BAccNo)
                .HasMaxLength(45)
                .HasColumnName("b_acc_no");
            entity.Property(e => e.BContact)
                .HasMaxLength(12)
                .HasColumnName("b_contact");
            entity.Property(e => e.BankName)
                .HasMaxLength(45)
                .HasColumnName("bank_name");
            entity.Property(e => e.Fname)
                .HasMaxLength(45)
                .HasColumnName("fname");
            entity.Property(e => e.IfscCode)
                .HasMaxLength(45)
                .HasColumnName("ifsc_code");
            entity.Property(e => e.Lname)
                .HasMaxLength(45)
                .HasColumnName("lname");
            entity.Property(e => e.UserId).HasColumnName("user_id");

            entity.HasOne(d => d.User).WithMany(p => p.Buyers)
                .HasForeignKey(d => d.UserId)
                .HasConstraintName("user_id_fk");
        });

        modelBuilder.Entity<Category>(entity =>
        {
            entity.HasKey(e => e.CatId).HasName("PRIMARY");

            entity.ToTable("category");

            entity.Property(e => e.CatId)
                .ValueGeneratedNever()
                .HasColumnName("cat_id");
            entity.Property(e => e.CatName)
                .HasMaxLength(45)
                .HasColumnName("cat_name");
        });

        modelBuilder.Entity<Company>(entity =>
        {
            entity.HasKey(e => e.ComId).HasName("PRIMARY");

            entity.ToTable("company");

            entity.Property(e => e.ComId).HasColumnName("com_id");
            entity.Property(e => e.ComName)
                .HasMaxLength(45)
                .HasColumnName("com_name");
        });

        modelBuilder.Entity<Interest>(entity =>
        {
            entity.HasKey(e => e.InterestId).HasName("PRIMARY");

            entity.ToTable("interest");

            entity.HasIndex(e => e.BId, "buyer_nm_idx");

            entity.HasIndex(e => e.VId, "vehicle_id_idx");

            entity.Property(e => e.InterestId).HasColumnName("interest_id");
            entity.Property(e => e.BId).HasColumnName("b_id");
            entity.Property(e => e.VId).HasColumnName("v_id");

            entity.HasOne(d => d.BIdNavigation).WithMany(p => p.Interests)
                .HasForeignKey(d => d.BId)
                .HasConstraintName("buyer_nm");

            entity.HasOne(d => d.VIdNavigation).WithMany(p => p.Interests)
                .HasForeignKey(d => d.VId)
                .HasConstraintName("vehicle_id");
        });

        modelBuilder.Entity<Model>(entity =>
        {
            entity.HasKey(e => e.ModelId).HasName("PRIMARY");

            entity.ToTable("model");

            entity.HasIndex(e => e.ComId, "fk_com_id_idx");

            entity.HasIndex(e => e.ModelName, "model_name_UNIQUE").IsUnique();

            entity.Property(e => e.ModelId).HasColumnName("model_id");
            entity.Property(e => e.ComId).HasColumnName("com_id");
            entity.Property(e => e.ModelName)
                .HasMaxLength(45)
                .HasColumnName("model_name");

            entity.HasOne(d => d.Com).WithMany(p => p.Models)
                .HasForeignKey(d => d.ComId)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("fk_com_id");
        });

        modelBuilder.Entity<Payment>(entity =>
        {
            entity.HasKey(e => e.PaymentId).HasName("PRIMARY");

            entity.ToTable("payment");

            entity.HasIndex(e => e.BookId, "booking_id_idx");

            entity.HasIndex(e => e.Date, "datee_idx");

            entity.Property(e => e.PaymentId).HasColumnName("payment_id");
            entity.Property(e => e.Amount).HasColumnName("amount");
            entity.Property(e => e.BookId).HasColumnName("book_id");
            entity.Property(e => e.Date)
                .HasColumnType("datetime")
                .HasColumnName("date");

            entity.HasOne(d => d.Book).WithMany(p => p.Payments)
                .HasForeignKey(d => d.BookId)
                .HasConstraintName("booking_id");
        });

        modelBuilder.Entity<Role>(entity =>
        {
            entity.HasKey(e => e.RoleId).HasName("PRIMARY");

            entity.ToTable("roles");

            entity.HasIndex(e => e.RoleId, "role_id_UNIQUE").IsUnique();

            entity.Property(e => e.RoleId)
                .ValueGeneratedNever()
                .HasColumnName("role_id");
            entity.Property(e => e.RoleName)
                .HasMaxLength(45)
                .HasColumnName("role_name");
        });

        modelBuilder.Entity<Seller>(entity =>
        {
            entity.HasKey(e => e.SId).HasName("PRIMARY");

            entity.ToTable("seller");

            entity.HasIndex(e => e.SContact, "s_contact_UNIQUE").IsUnique();

            entity.HasIndex(e => e.UserId, "uid_fk");

            entity.Property(e => e.SId).HasColumnName("s_id");
            entity.Property(e => e.Address)
                .HasMaxLength(45)
                .HasColumnName("address");
            entity.Property(e => e.BankName)
                .HasMaxLength(45)
                .HasColumnName("bank_name");
            entity.Property(e => e.Fname)
                .HasMaxLength(45)
                .HasColumnName("fname");
            entity.Property(e => e.IfscCode)
                .HasMaxLength(45)
                .HasColumnName("ifsc_code");
            entity.Property(e => e.Lname)
                .HasMaxLength(45)
                .HasColumnName("lname");
            entity.Property(e => e.SAccNo)
                .HasMaxLength(45)
                .HasColumnName("s_acc_no");
            entity.Property(e => e.SContact)
                .HasMaxLength(45)
                .HasColumnName("s_contact");
            entity.Property(e => e.UserId).HasColumnName("user_id");

            entity.HasOne(d => d.User).WithMany(p => p.Sellers)
                .HasForeignKey(d => d.UserId)
                .HasConstraintName("uid_fk");
        });

        modelBuilder.Entity<SubCategory>(entity =>
        {
            entity.HasKey(e => e.SubcatId).HasName("PRIMARY");

            entity.ToTable("sub_category");

            entity.HasIndex(e => e.CatId, "catagory_id_idx");

            entity.Property(e => e.SubcatId)
                .ValueGeneratedNever()
                .HasColumnName("subcat_id");
            entity.Property(e => e.CatId).HasColumnName("cat_id");
            entity.Property(e => e.SubcatName)
                .HasMaxLength(45)
                .HasColumnName("subcat_name");

            entity.HasOne(d => d.Cat).WithMany(p => p.SubCategories)
                .HasForeignKey(d => d.CatId)
                .HasConstraintName("catagory_id");
        });

        modelBuilder.Entity<User>(entity =>
        {
            entity.HasKey(e => e.Uid).HasName("PRIMARY");

            entity.ToTable("users");

            entity.HasIndex(e => e.Rid, "rid_fk_idx");

            entity.HasIndex(e => e.Username, "username_UNIQUE").IsUnique();

            entity.Property(e => e.Uid).HasColumnName("uid");
           /* entity.Property(e => e.Email)
                .HasMaxLength(45)
                .HasColumnName("email");*/
            entity.Property(e => e.Password)
                .HasMaxLength(100)
                .HasColumnName("password");
            entity.Property(e => e.Rid).HasColumnName("rid");
            entity.Property(e => e.Username)
                .HasMaxLength(45)
                .HasColumnName("username");

            entity.HasOne(d => d.Role).WithMany(p => p.Users)
                .HasForeignKey(d => d.Rid)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("rid_fk");
        });

        modelBuilder.Entity<Vehicle>(entity =>
        {
            entity.HasKey(e => e.VId).HasName("PRIMARY");

            entity.ToTable("vehicle");

            entity.HasIndex(e => e.CatId, "cat_id_fk_idx");

            entity.HasIndex(e => e.ComId, "com_id_fk_idx");

            entity.HasIndex(e => e.ModelId, "fk_model_id_idx");

            entity.HasIndex(e => e.SId, "s_id_fk");

            entity.HasIndex(e => e.ScatId, "scat_id_fk_idx");

            entity.Property(e => e.VId).HasColumnName("v_id");
            entity.Property(e => e.CatId).HasColumnName("cat_id");
            entity.Property(e => e.ComId).HasColumnName("com_id");
            entity.Property(e => e.EngineCapacity).HasColumnName("engine_capacity");
            entity.Property(e => e.FuelType)
                .HasMaxLength(15)
                .HasColumnName("fuel_type");
            entity.Property(e => e.KmsDriven)
                .HasMaxLength(10)
                .HasColumnName("kms_driven");
            entity.Property(e => e.ModelId).HasColumnName("model_id");
            entity.Property(e => e.NoOfSeats).HasColumnName("no_of_seats");
            entity.Property(e => e.Ownership).HasColumnName("ownership");
            entity.Property(e => e.RegistrationYear)
                .HasMaxLength(10)
                .HasColumnName("registration_year");
            entity.Property(e => e.Rto)
                .HasMaxLength(45)
                .HasColumnName("rto");
            entity.Property(e => e.SId).HasColumnName("s_id");
            entity.Property(e => e.ScatId).HasColumnName("scat_id");
            entity.Property(e => e.Transmission)
                .HasMaxLength(20)
                .HasColumnName("transmission");
            entity.Property(e => e.VImages)
                .HasMaxLength(255)
                .HasColumnName("v_images");
            entity.Property(e => e.VPrice).HasColumnName("v_price");

            entity.HasOne(d => d.Cat).WithMany(p => p.Vehicles)
                .HasForeignKey(d => d.CatId)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("cat_id_fk");

            entity.HasOne(d => d.Com).WithMany(p => p.Vehicles)
                .HasForeignKey(d => d.ComId)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("com_id_fk");

            entity.HasOne(d => d.ModelNavigation).WithMany(p => p.Vehicles)
                .HasForeignKey(d => d.ModelId)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("fk_model_id");

            entity.HasOne(d => d.SIdNavigation).WithMany(p => p.Vehicles)
                .HasForeignKey(d => d.SId)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("s_id_fk");

            entity.HasOne(d => d.Scat).WithMany(p => p.Vehicles)
                .HasForeignKey(d => d.ScatId)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("scat_id_fk");
        });

        modelBuilder.Entity<Verification>(entity =>
        {
            entity.HasKey(e => e.VerificationId).HasName("PRIMARY");

            entity.ToTable("verification");

            entity.HasIndex(e => e.BId, "buyer_idx");

            entity.HasIndex(e => e.PaymentId, "paymentid_idx");

            entity.HasIndex(e => e.SId, "seller_idx");

            entity.Property(e => e.VerificationId).HasColumnName("verification_id");
            entity.Property(e => e.BId).HasColumnName("b_id");
            entity.Property(e => e.BuyrConf).HasColumnName("buyr_conf");
            entity.Property(e => e.PaymentId).HasColumnName("payment_id");
            entity.Property(e => e.SId).HasColumnName("s_id");
            entity.Property(e => e.SellrConf).HasColumnName("sellr_conf");
            entity.Property(e => e.AdminConf).HasColumnName("admin_conf");

            entity.HasOne(d => d.BIdNavigation).WithMany(p => p.Verifications)
                .HasForeignKey(d => d.BId)
                .HasConstraintName("buyer");

            entity.HasOne(d => d.Payment).WithMany(p => p.Verifications)
                .HasForeignKey(d => d.PaymentId)
                .HasConstraintName("paymentid");

            entity.HasOne(d => d.SIdNavigation).WithMany(p => p.Verifications)
                .HasForeignKey(d => d.SId)
                .HasConstraintName("seller");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
