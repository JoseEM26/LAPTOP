
namespace ConsultaDNI
{
    partial class FrmConsultaDNI
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.txtNumeroDNI = new System.Windows.Forms.TextBox();
            this.btnConsultarDNIMediantePaginaExterna = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.txtApellidoPaterno = new System.Windows.Forms.TextBox();
            this.txtApellidoMaterno = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.txtNombres = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.lblMensaje = new System.Windows.Forms.Label();
            this.btnConsultarDNIMedianteJNE = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.Anchor = System.Windows.Forms.AnchorStyles.Top;
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Arial", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(224, 10);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(96, 16);
            this.label1.TabIndex = 22;
            this.label1.Text = "Número de DNI";
            // 
            // txtNumeroDNI
            // 
            this.txtNumeroDNI.Anchor = System.Windows.Forms.AnchorStyles.Top;
            this.txtNumeroDNI.Font = new System.Drawing.Font("Arial", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtNumeroDNI.Location = new System.Drawing.Point(227, 26);
            this.txtNumeroDNI.MaxLength = 8;
            this.txtNumeroDNI.Name = "txtNumeroDNI";
            this.txtNumeroDNI.Size = new System.Drawing.Size(250, 25);
            this.txtNumeroDNI.TabIndex = 0;
            this.txtNumeroDNI.Text = "12345678";
            // 
            // btnConsultarDNIMediantePaginaExterna
            // 
            this.btnConsultarDNIMediantePaginaExterna.Anchor = System.Windows.Forms.AnchorStyles.Top;
            this.btnConsultarDNIMediantePaginaExterna.BackColor = System.Drawing.Color.White;
            this.btnConsultarDNIMediantePaginaExterna.FlatAppearance.BorderColor = System.Drawing.Color.Firebrick;
            this.btnConsultarDNIMediantePaginaExterna.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnConsultarDNIMediantePaginaExterna.Location = new System.Drawing.Point(249, 57);
            this.btnConsultarDNIMediantePaginaExterna.Name = "btnConsultarDNIMediantePaginaExterna";
            this.btnConsultarDNIMediantePaginaExterna.Size = new System.Drawing.Size(90, 50);
            this.btnConsultarDNIMediantePaginaExterna.TabIndex = 1;
            this.btnConsultarDNIMediantePaginaExterna.Text = "Consultar DNI mediante página externa";
            this.btnConsultarDNIMediantePaginaExterna.UseVisualStyleBackColor = false;
            this.btnConsultarDNIMediantePaginaExterna.Click += new System.EventHandler(this.btnConsultarDNIMediantePaginaExterna_Click);
            // 
            // label2
            // 
            this.label2.Font = new System.Drawing.Font("Arial", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(49, 141);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(130, 16);
            this.label2.TabIndex = 25;
            this.label2.Text = "Apellido Paterno: ";
            // 
            // txtApellidoPaterno
            // 
            this.txtApellidoPaterno.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtApellidoPaterno.Font = new System.Drawing.Font("Arial", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtApellidoPaterno.Location = new System.Drawing.Point(185, 135);
            this.txtApellidoPaterno.MaxLength = 11;
            this.txtApellidoPaterno.Name = "txtApellidoPaterno";
            this.txtApellidoPaterno.ReadOnly = true;
            this.txtApellidoPaterno.Size = new System.Drawing.Size(350, 22);
            this.txtApellidoPaterno.TabIndex = 2;
            // 
            // txtApellidoMaterno
            // 
            this.txtApellidoMaterno.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtApellidoMaterno.Font = new System.Drawing.Font("Arial", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtApellidoMaterno.Location = new System.Drawing.Point(185, 168);
            this.txtApellidoMaterno.MaxLength = 11;
            this.txtApellidoMaterno.Name = "txtApellidoMaterno";
            this.txtApellidoMaterno.ReadOnly = true;
            this.txtApellidoMaterno.Size = new System.Drawing.Size(350, 22);
            this.txtApellidoMaterno.TabIndex = 3;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Arial", 9.75F);
            this.label3.Location = new System.Drawing.Point(43, 174);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(113, 16);
            this.label3.TabIndex = 27;
            this.label3.Text = "Apellido Materno: ";
            // 
            // txtNombres
            // 
            this.txtNombres.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtNombres.Font = new System.Drawing.Font("Arial", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtNombres.Location = new System.Drawing.Point(185, 204);
            this.txtNombres.MaxLength = 11;
            this.txtNombres.Name = "txtNombres";
            this.txtNombres.ReadOnly = true;
            this.txtNombres.Size = new System.Drawing.Size(350, 22);
            this.txtNombres.TabIndex = 4;
            // 
            // label5
            // 
            this.label5.Font = new System.Drawing.Font("Arial", 9.75F);
            this.label5.Location = new System.Drawing.Point(46, 210);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(133, 16);
            this.label5.TabIndex = 29;
            this.label5.Text = "Nombres: ";
            // 
            // lblMensaje
            // 
            this.lblMensaje.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.lblMensaje.Font = new System.Drawing.Font("Arial", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblMensaje.ForeColor = System.Drawing.Color.Firebrick;
            this.lblMensaje.Location = new System.Drawing.Point(26, 110);
            this.lblMensaje.Name = "lblMensaje";
            this.lblMensaje.Size = new System.Drawing.Size(646, 15);
            this.lblMensaje.TabIndex = 48;
            this.lblMensaje.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // btnConsultarDNIMedianteJNE
            // 
            this.btnConsultarDNIMedianteJNE.Anchor = System.Windows.Forms.AnchorStyles.Top;
            this.btnConsultarDNIMedianteJNE.BackColor = System.Drawing.Color.Firebrick;
            this.btnConsultarDNIMedianteJNE.FlatAppearance.BorderSize = 0;
            this.btnConsultarDNIMedianteJNE.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnConsultarDNIMedianteJNE.ForeColor = System.Drawing.Color.White;
            this.btnConsultarDNIMedianteJNE.Location = new System.Drawing.Point(354, 57);
            this.btnConsultarDNIMedianteJNE.Name = "btnConsultarDNIMedianteJNE";
            this.btnConsultarDNIMedianteJNE.Size = new System.Drawing.Size(90, 50);
            this.btnConsultarDNIMedianteJNE.TabIndex = 50;
            this.btnConsultarDNIMedianteJNE.Text = "Consultar DNI mediante JNE";
            this.btnConsultarDNIMedianteJNE.UseVisualStyleBackColor = false;
            this.btnConsultarDNIMedianteJNE.Click += new System.EventHandler(this.btnConsultarDNIMedianteJNE_Click);
            // 
            // FrmConsultaDNI
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(684, 311);
            this.Controls.Add(this.btnConsultarDNIMedianteJNE);
            this.Controls.Add(this.lblMensaje);
            this.Controls.Add(this.txtNombres);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.txtApellidoMaterno);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.txtApellidoPaterno);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtNumeroDNI);
            this.Controls.Add(this.btnConsultarDNIMediantePaginaExterna);
            this.Name = "FrmConsultaDNI";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Consulta de número de DNI";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtNumeroDNI;
        private System.Windows.Forms.Button btnConsultarDNIMediantePaginaExterna;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtApellidoPaterno;
        private System.Windows.Forms.TextBox txtApellidoMaterno;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txtNombres;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label lblMensaje;
        private System.Windows.Forms.Button btnConsultarDNIMedianteJNE;
    }
}

