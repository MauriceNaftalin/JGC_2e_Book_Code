package chapter07.B_enforce_type_safety_when_calling_untrusted_code;
// ch08_2_4
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class WaryBroker_1 {
  public void connect(OrderSupplier supplier, OrderProcessor processor) {
    List<AuthenticatedOrder> orders = new ArrayList<AuthenticatedOrder>();
    supplier.addOrders(Collections.checkedList(orders, AuthenticatedOrder.class));
    processor.processOrders(orders);
  }

}