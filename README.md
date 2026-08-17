# ServiceHub

ServiceHub is a **microservices-based service booking platform** built with Java and Spring Boot. The platform connects customers with service providers, allowing customers to discover services, book available time slots, make payments, and manage reviews and notifications.

The project is being developed incrementally, starting with a complete **V1 end-to-end workflow**, followed by distributed-system integrations and production hardening.

## Architecture

                         ┌──────────────────┐
                         │   API Gateway    │
                         └────────┬─────────┘
                                  │
              ┌───────────────────┼───────────────────┐
              │                   │                   │
      ┌───────▼───────┐   ┌──────▼──────┐   ┌───────▼───────┐
      │  Auth Service │   │   Provider  │   │    Booking    │
      │               │   │   Service   │   │    Service    │
      └───────────────┘   └─────────────┘   └───────┬───────┘
                                                     │
                                           ┌─────────▼─────────┐
                                           │  Payment Service  │
                                           └─────────┬─────────┘
                                                     │
                                  ┌──────────────────┼──────────────────┐
                                  │                  │                  │
                           ┌──────▼──────┐   ┌──────▼──────┐   ┌──────▼──────┐
                           │   Review    │   │ Notification│   │   Future     │
                           │   Service   │   │   Service   │   │ Integrations │
                           └─────────────┘   └─────────────┘   └─────────────┘

              ┌─────────────────────────────────────────────┐
              │              Service Discovery              │
              │                    Eureka                   │
              └─────────────────────────────────────────────┘

              ┌─────────────────────────────────────────────┐
              │                Config Server                │
              └─────────────────────────────────────────────┘

## Tech Stack

### Backend

* Java 21
* Spring Boot 4.1
* Spring Cloud
* Spring Data JPA
* Spring Security
* Spring Cloud Gateway
* Eureka Discovery
* Spring Cloud Config Server

### Database & Persistence

* PostgreSQL
* Flyway
* Hibernate / JPA

### Authentication

* Auth0
* OAuth 2.0 / JWT
* M2M authentication

### Development

* MapStruct
* Lombok
* Maven
* REST APIs

## Services

| Service                | Responsibility                                    | Status |
| ---------------------- | ------------------------------------------------- | ------ |
| `gateway-service`      | API Gateway / routing                             | ✅      |
| `config-server`        | Centralized configuration                         | ✅      |
| `discovery-service`    | Eureka service discovery                          | ✅      |
| `auth-service`         | Auth0 integration and user synchronization        | ✅      |
| `provider-service`     | Providers, categories, offerings and availability | ✅      |
| `booking-service`      | Booking lifecycle                                 | ✅      |
| `payment-service`      | Payment processing                                | ⏳      |
| `review-service`       | Customer reviews                                  | ⏳      |
| `notification-service` | Notifications                                     | ⏳      |

## Current V1 Progress

### Auth Service

* Auth0 configured
* M2M authentication working
* `servicehub-api` audience configured
* Auth0 user synchronization implemented

### Provider Service

* Provider CRUD
* Service categories
* Provider offerings are associated with provider and category
* Availability slots are associated with provider offerings
* Day-of-week availability
* MapStruct mapping
* Flyway database migrations

### Booking Service

The first complete V1 booking workflow is now working end-to-end:

    Customer
       ↓
    Select Provider Offering
       ↓
    Select Availability Slot
       ↓
    Create Booking
       ↓
    Confirm Booking

The Booking Service communicates with Provider Service using
a load-balanced `RestClient` and Eureka service discovery.

The current workflow supports:

* Customer creation
* Provider offering selection
* Availability slot selection
* Offering and slot validation
* Provider/slot relationship validation
* Booking creation
* Booking confirmation
* Total price calculation from the provider offering
* Persistence of bookings

A successful V1 booking has been tested end-to-end.

For V1 workflow development, demo Auth0 IDs are intentionally used. JWT extraction, authorization and RBAC will be integrated after the complete V1 business workflow is working.

### Current V1 Status

The core Provider → Booking workflow is operational.

Successfully tested:

* Provider registration and discovery through Eureka
* Centralized configuration through Config Server
* Provider offerings
* Availability slots
* Customer creation
* Booking Service → Provider Service communication
* Load-balanced REST communication
* End-to-end booking creation
* Booking confirmation
* Price propagation from offering to booking

Example successful booking:

    {
      "id": 1,
      "customerId": 2,
      "providerId": 1,
      "offeringId": 3,
      "slotId": 5,
      "status": "CONFIRMED",
      "totalPrice": 500.0
    }

## Development Approach

The project is intentionally developed in three stages:

### Stage 1 — End-to-End V1

Auth
  ↓
Provider
  ↓
Booking
  ↓
Payment
  ↓
Review
  ↓
Notification

Focus: complete business workflow and service communication.

### Stage 2 — Distributed Integrations

* OpenFeign
* Apache Kafka
* Event-driven communication
* Distributed transactions
* Saga pattern
* Caching
* Docker
* Kubernetes basics

### Stage 3 — Production Hardening

* JWT user extraction
* Auth0 propagation
* RBAC
* Authorization
* Resilience patterns
* Observability
* Centralized logging
* Health checks
* Performance improvements
* Security hardening
* Integration and end-to-end testing

## Project Conventions

* DTOs implemented as Java records
* MapStruct for Entity ↔ DTO mapping
* Constructor injection only
* Service interface + ServiceImpl pattern
* Entities extend a common `BaseEntity`
* Flyway is the source of truth for database schema
* JPA/Hibernate schema validation enabled
* REST communication used during V1
* OpenFeign planned for V2
* Kafka planned for V2
* No frontend currently

## Example V1 Booking Request

http
POST booking-service/api/booking
Content-Type: application/json

{
  "customerId": 2,
  "offeringId": 3,
  "slotId": 5
}

The current V1 implementation uses:

auth0|demo-customer

as the customer identity until Auth0 JWT integration is enabled.

## Learning & Goals

This project is also being used to brush up skills...

* Microservices architecture
* Service discovery
* Centralized configuration
* API Gateway
* Authentication and authorization
* REST-based service communication
* Database migrations
* Distributed transactions
* Event-driven architecture
* Kafka
* Saga pattern
* Docker and Kubernetes
* Production-ready Spring Boot services

## Roadmap

### V1 — Core Business Workflow

* [x] Auth Service
* [x] Provider Service
* [x] Booking Service
* [ ] Payment Service
* [ ] Review Service
* [ ] Notification Service
* [ ] End-to-End Integration Testing

### V2 — Distributed Systems & Production

* [ ] OpenFeign
* [ ] Kafka
* [ ] Saga / Distributed Transactions
* [ ] Caching
* [ ] Docker
* [ ] Kubernetes
* [ ] JWT / RBAC
* [ ] Observability
* [ ] Production hardening

---

**ServiceHub is an evolving project focused on building a realistic, production-oriented microservices architecture rather than a simple CRUD application.**
