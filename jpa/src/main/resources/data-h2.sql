MERGE INTO author (author_id, name, age, sex) KEY (author_id) VALUES ('cb153bea-4aa4-4b43-b402-91ebdaca10a0', 'FENGSHUAIJU', 20, '男');

MERGE INTO book (book_id, name, publish_day, create_at) KEY (book_id) VALUES ('0efa2323-c866-4d91-8885-fc1f5142d914', '时间简史', '2019-02-05', '2019-02-05 12:23:45');

MERGE INTO book_chapter (name, summary, index, book_id) KEY (name, summary, index, book_id) VALUES ('未来世界', '未来世界的人们', 4, '0efa2323-c866-4d91-8885-fc1f5142d914');
