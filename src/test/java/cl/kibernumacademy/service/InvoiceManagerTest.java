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
    // Arrange (Preparar) .. Crear una factura primero, para luego actualizar su estado
    Invoice invoice = manager.createInvoice("CloudTech", 1500.0);

    // Act (Actuar) .. Actualizar el estado de la factura creada
    boolean updated = manager.updateStatus(invoice.getId(), "PAGADA");

    // Assert (Verificar 1) - Comprobamos los resultados
    assertThat(updated).isTrue();
    // Assert (Verificar 2) - El estado de la factura debe ser "PAGADA"
    assertThat(invoice.getStatus()).isEqualTo("PAGADA");
  }

  @Test
  void deberiaEliminarFactura() {
    // Arrange (Preparar) .. Crear una factura primero, para luego actualizar su estado
    Invoice invoice = manager.createInvoice("CloudTech", 1500.0);

    // Act (Actuar) .. Eliminar la factura creada
    boolean removed = manager.deleteInvoice(invoice.getId());

    // Assert (Verificar) - Comprobamos los resultados

    // Verficación 1: La eliminación debe ser exitosa
    assertThat(removed).isTrue();
    // Verificación 2: La lista de facturas debe estar vacía
    assertThat(manager.getAll()).isEmpty();

  }
}
