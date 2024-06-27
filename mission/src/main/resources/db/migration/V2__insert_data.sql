-- Insert sample data into the category table
INSERT INTO category (id, name, description)
VALUES
    (nextval('category_seq'), 'Java Development', 'Java development projects'),
    (nextval('category_seq'), '.NET Development', 'Dot NET development projects'),
    (nextval('category_seq'), 'Business Intelligence', 'BI projects and analysis'),
    (nextval('category_seq'), 'Design', 'UI/UX and graphic design projects');

-- Insert sample data into the mission table
INSERT INTO mission (id, title, description, start_date, end_date, status, category_id, tjm, address, phone, email)
VALUES
    (nextval('mission_seq'), 'Java Web Application', 'Develop a web application using Spring Boot and Angular', '2024-06-01', '2024-12-01', 'In Progress', (SELECT id FROM category WHERE name = 'Java Development'), 15000.00, '123 Java St', '555-1234', 'java.dev@example.com'),
    (nextval('mission_seq'), 'Enterprise .NET Application', 'Create an enterprise-level application using ASP.NET Core', '2024-07-01', '2024-12-31', 'Planned', (SELECT id FROM category WHERE name = '.NET Development'), 20000.00, '456 NET Ave', '555-5678', 'dotnet.dev@example.com'),
    (nextval('mission_seq'), 'BI Dashboard Development', 'Develop interactive dashboards using Power BI', '2024-08-01', '2024-11-01', 'In Progress', (SELECT id FROM category WHERE name = 'Business Intelligence'), 10000.00, '789 BI Blvd', '555-7890', 'bi.dev@example.com'),
    (nextval('mission_seq'), 'UI/UX Redesign', 'Redesign the UI/UX of the company’s main product', '2024-09-01', '2024-12-01', 'Planned', (SELECT id FROM category WHERE name = 'Design'), 8000.00, '101 Design Dr', '555-1010', 'design.dev@example.com');