package chapter07.B_enforce_type_safety_when_calling_untrusted_code;
// ch08_2_6
import java.util.List;

class WaryBroker_2 {
  public void connect(OrderSupplier supplier, OrderProcessor processor) {
    List<AuthenticatedOrder> orders = supplier.getOrders();
    for (AuthenticatedOrder order : orders) {}
  }

}