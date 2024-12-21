<section class="page-section" id="contact">
    <div class="container">
        <div class="text-center">
            <h2 class="section-heading text-uppercase">Contáctanos</h2>
            <h3 class="section-subheading text-muted">
                Mándanos un mensaje con todos tus datos y próximamente nos estaremos comunicando contigo.
            </h3>
        </div>
        <form action="contactanos" method="POST">
            <div class="row align-items-stretch mb-5">
                <!-- Información del usuario -->
                <div class="col-md-6">
                    <div class="form-group">
                        <!-- Nombre -->
                        <label for="name">Nombre</label>
                        <input
                            class="form-control w-100"
                            id="name"
                            type="text"
                            name="name"
                            placeholder="Ingrese su nombre *"
                            required
                        />
                        <div class="invalid-feedback">
                            El nombre es obligatorio.
                        </div>
                    </div>
                    <div class="form-group mt-3">
                        <!-- Correo -->
                        <label for="email">Correo electrónico</label>
                        <input
                            class="form-control w-100"
                            id="email"
                            type="email"
                            name="email"
                            placeholder="Ingrese su email *"
                            pattern=".*@(hotmail\.com|gmail\.com)"
                            required
                        />
                        <div class="invalid-feedback">
                            Ingresa un correo válido (Hotmail o Gmail).
                        </div>
                    </div>
                    <div class="form-group mt-3">
                        <!-- Teléfono -->
                        <label for="phone">Número de teléfono</label>
                        <input
                            class="form-control w-100"
                            id="phone"
                            type="tel"
                            name="phone"
                            placeholder="Ingrese su número celular *"
                            required
                        />
                        <div class="invalid-feedback">
                            El número de celular es obligatorio.
                        </div>
                    </div>
                </div>
                <!-- Mensaje -->
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="message">Mensaje</label>
                        <textarea
                            class="form-control w-100"
                            id="message"
                            name="message"
                            rows="6"
                            placeholder="Escribe tu mensaje aquí *"
                            required
                        ></textarea>
                        <div class="invalid-feedback">
                            El mensaje es obligatorio.
                        </div>
                    </div>
                </div>
            </div>
            <!-- Botón de envío -->
            <div class="text-center">
                <button class="btn btn-primary btn-xl text-uppercase" type="submit">
                    Enviar Mensaje
                </button>
            </div>
            ${mensajeContactanos }
        </form>
    </div>
</section>
