package chapter07.B_enforce_type_safety_when_calling_untrusted_code;
// ch08_2_1
import java.util.List;

class Order {}
class AuthenticatedOrder extends Order {}

interface OrderSupplier {
  public void addOrders(List<AuthenticatedOrder> orders);
  public List<AuthenticatedOrder> getOrders();
}
interface OrderProcessor {
  public void processOrders(List<? extends Order> orders);

}