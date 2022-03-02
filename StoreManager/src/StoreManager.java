public class StoreManager {

    private static StoreManager instance = null;

    private SQLiteDataAdapter dao;

    private ProductView productView = null;

    private MainScreen mainScreen = null;

    private OrderView orderView = null;

    private CustomerView customerView = null;

    private CustomerController customerController = null;

    private ProductController productController = null;

    private OrderController orderController = null; //Basing this off the product controller

    public ProductView getProductView() {
        return productView;
    }

    public MainScreen getMainScreen() {
        return mainScreen;
    }

    public OrderView getOrderView() {
        return orderView;
    }

    public CustomerView getCustomerView() {return customerView;}









    public static StoreManager getInstance() {
        if (instance == null)
            instance = new StoreManager("SQLite");
        return instance;
    }

    public SQLiteDataAdapter getDataAccess() {
        return dao;
    }

    private StoreManager(String db) {
        // do some initialization here!!!
        if (db.equals("SQLite"))
            dao = new SQLiteDataAdapter();

        dao.connect();
        productView = new ProductView();
        mainScreen = new MainScreen();
        productController = new ProductController(productView, dao);
        orderView = new OrderView();
        orderController = new OrderController(orderView, dao);
        customerView = new CustomerView();
        customerController = new CustomerController(customerView, dao);

    }

}
