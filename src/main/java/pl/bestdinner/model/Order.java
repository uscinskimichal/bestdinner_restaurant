package pl.bestdinner.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "orders")
public class Order {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "order_id")
  private Long orderId;

  @Column(name = "date")
  private Timestamp date;

  @Column(name = "type")
  private String type;

  @Column(name = "comment")
  private String comment;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "address_id")
  private Address address;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "table_id")
  private Table table;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employee_id")
  private Employee employee;

  @OneToMany(mappedBy = "order")
  private Set<OrderHistory> orderHistorySet;

  @OneToMany(mappedBy = "order")
  private Set<OrderItem> orderItems;

  @ManyToMany(mappedBy = "orders")
  private List<Client> clients;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "status_id")
  private Status status;

}
