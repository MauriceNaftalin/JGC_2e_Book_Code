package chapter07.B_enforce_type_safety_when_calling_untrusted_code;
// ch08_2_3
import java.util.List;

class DeviousSupplier_1 implements OrderSupplier {
  public void addOrders(List<AuthenticatedOrder> orders) {
    List raw = orders;
    Order order = new Order(); // not authenticated
    raw.add(order);            // unchecked call
  }
  public List<AuthenticatedOrder> getOrders() {
    // ...
  }

}