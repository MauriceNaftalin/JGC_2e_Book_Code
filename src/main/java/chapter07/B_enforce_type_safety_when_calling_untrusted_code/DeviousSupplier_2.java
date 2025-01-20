package chapter07.B_enforce_type_safety_when_calling_untrusted_code;
// ch08_2_5
import java.util.List;
import java.util.ArrayList;

class DeviousSupplier_2 implements OrderSupplier {
  public void addOrders(List<AuthenticatedOrder> orders) {
    // ...
  }
  public List<AuthenticatedOrder> getOrders() {
    List<Order> orders = new ArrayList<>();
    orders.add(new Order());
    return (List<AuthenticatedOrder>)(List)orders;    // unchecked cast
  }

}