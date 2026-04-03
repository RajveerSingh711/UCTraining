-- Quantity Measurement Entity Table for Testing
CREATE TABLE IF NOT EXISTS quantity_measurement_entity (
    id INT AUTO_INCREMENT PRIMARY KEY,
    this_value DOUBLE,
    this_unit VARCHAR(255),
    this_measurement_type VARCHAR(255),
    that_value DOUBLE,
    that_unit VARCHAR(255),
    that_measurement_type VARCHAR(255),
    operation VARCHAR(255),
    result_value DOUBLE,
    result_unit VARCHAR(255),
    result_measurement_type VARCHAR(255),
    result_string VARCHAR(255),
    is_error BOOLEAN,
    error_message VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
