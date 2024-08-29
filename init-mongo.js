db.createCollection("Orders");

db.Orders.insertMany([
  {
    _id: '1',
    clientId: 1,
    products: [1],
    total: 250.75
  },
]);

