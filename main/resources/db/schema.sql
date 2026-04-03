-- Quantity Measurement Entity Table
CREATE TABLE IF NOT EXISTS quantity_measurement_entity (
    id INT AUTO_INCREMENT PRIMARY KEY,
    this_value DOUBLE NOT NULL,
    this_unit VARCHAR(255) NOT NULL,
    this_measurement_type VARCHAR(255) NOT NULL,
    that_value DOUBLE,
    that_unit VARCHAR(255),
    that_measurement_type VARCHAR(255),
    operation VARCHAR(255) NOT NULL,
    result_value DOUBLE,
    result_unit VARCHAR(255),
    result_measurement_type VARCHAR(255),
    result_string VARCHAR(255),
    is_error BOOLEAN DEFAULT FALSE,
    error_message VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Index for querying by measurement type
CREATE INDEX IF NOT EXISTS idx_measurement_type ON quantity_measurement_entity(this_measurement_type);

-- Index for querying by operation
CREATE INDEX IF NOT EXISTS idx_operation ON quantity_measurement_entity(operation);
