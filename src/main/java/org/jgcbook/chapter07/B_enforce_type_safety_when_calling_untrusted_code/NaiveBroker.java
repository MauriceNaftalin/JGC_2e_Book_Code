package org.jgcbook.chapter07.B_enforce_type_safety_when_calling_untrusted_code;
// ch08_2_2
import java.util.List;
import java.util.ArrayList;

class NaiveBroker {
  public void connect(OrderSupplier supplier, OrderProcessor processor) {
    List<AuthenticatedOrder> orders = new ArrayList<>();
    supplier.addOrders(orders);
    processor.processOrders(orders);
  }

}