package cl.kibernumacademy.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cl.kibernumacademy.model.Invoice;

import static org.assertj.core.api.Assertions.*;

public class InvoiceManagerTest {
  // Variable de instancia que contendrá el objeto bajo prueba
  private InvoiceManager manager;

  @BeforeEach
  void setUp() {
    // Inicialización nueva para todos los tests
    manager = new InvoiceManager();
  }


  @Test
  void deberiaCrearUnaFactura() {
    // Arrange (Preparar)
    // No hay preparacion inicial adicional usamos el manager del setUp

    // Act (Actuar)
    Invoice invoice = manager.createInvoice("CloudTech", 1500.0);

    // Assert
    // Verificacion el ID de la primera factura debe ser 1
    assertThat(invoice.getId()).isEqualTo(1);
    // Verificación la lista de facturas debe contener exactamente un elemento
    assertThat(manager.getAll()).hasSize(1);
  }

  @Test
  void deberiaActualizarEstado() {
    // Arrange (Preparar)

  }

  @Test
  void deberiaEliminarFactura() {
    // Arrange (Preparar)

  }
}
