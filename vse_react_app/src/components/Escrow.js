import React, { useState } from 'react';
import { Form, Button, Container, Row, Col, Alert, Card } from 'react-bootstrap';

const Escrow = ({ vehicle }) => {
  const [buyer, setBuyer] = useState('');
  const [terms, setTerms] = useState('');
  const [message, setMessage] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

    if (buyer && terms) {
      // Handle the form submission logic here
      // This could involve calling an API to create the escrow transaction

      setMessage('Escrow transaction initiated successfully!');
    } else {
      setMessage('Please fill in all the fields.');
    }
  };

  return (
    <Container className="mt-5">
      <Row className="justify-content-md-center">
        <Col md={8}>
          <Card>
            <Card.Header as="h2" className="text-center">Initiate Escrow Transaction</Card.Header>
            <Card.Body>
              {message && <Alert variant="info">{message}</Alert>}
              
              <Card className="mb-4">
                <Card.Header as="h5">Vehicle Details</Card.Header>
                <Card.Body>
                  <p><strong>Model Name:</strong> {vehicle.model.modelName}</p>
                  <p><strong>Company Name:</strong> {vehicle.company.companyName}</p>
                  <p><strong>Price:</strong> {vehicle.vehiclePrice}</p>
                  {/* Add more details if needed */}
                </Card.Body>
              </Card>

              <Form onSubmit={handleSubmit}>
                <Form.Group controlId="buyer">
                  <Form.Label>Buyer Name</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="Enter your name"
                    value={buyer}
                    onChange={(e) => setBuyer(e.target.value)}
                  />
                </Form.Group>

                <Form.Group controlId="terms" className="mt-3">
                  <Form.Label>Comments</Form.Label>
                  <Form.Control
                    as="textarea"
                    rows={3}
                    placeholder="Enter Your Comment"
                    value={terms}
                    onChange={(e) => setTerms(e.target.value)}
                  />
                </Form.Group>

                <Button variant="primary" type="submit" className="mt-4 w-100">
                  Initiate Escrow
                </Button>
              </Form>
            </Card.Body>
          </Card>
        </Col>
      </Row>
    </Container>
  );
};

export default Escrow;
