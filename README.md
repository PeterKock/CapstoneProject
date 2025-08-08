# Capstone Project — Java Account Management System

This is the final assignment of a Java bootcamp course. The project demonstrates object-oriented design, basic service and repository patterns, and file processing in Java. It was built incrementally, with each step committed and documented along the way.

## Project Overview

The application simulates a simple financial system that supports two types of trading accounts:

- CashAccount: for standard trading with cash only
- MarginAccount: allows trading with borrowed funds

All accounts are initialized from a file. Transactions (deposits and withdrawals) are read from another file and applied to the correct accounts. The application then prints the final balances of selected accounts.

## Folder Structure

├── data/ # Contains accounts.txt and transactions.txt
├── pojo/ # Data model classes (TradeAccount, CashAccount, MarginAccount)
├── repository/ # In-memory data store with CRUD operations
├── service/ # Business logic for account operations
└── Main.java # Program entry point

## Concepts Demonstrated

- Object-oriented design with abstraction and inheritance
- Interface-driven service architecture
- Defensive data management using cloning
- File I/O with proper error handling
- Clean separation of concerns
- Manual testing via `Main.java`

## Commit Structure (Optional Summary)

This project was built across 4 parts:

**Part 1: Class hierarchy**
- Abstract `TradeAccount`
- Concrete `CashAccount` and `MarginAccount`
- Cloning and basic constructors

**Part 2: Repository layer**
- `TradeAccountRepository` with CRUD methods
- Encapsulates internal data with cloning

**Part 3: Service layer**
- Interface `TradeAccountService`
- Implementations: `CashAccountService`, `MarginAccountService`
- Logic for deposit, withdraw, and CRUD via service classes

**Part 4: Integration and Execution**
- File input (accounts and transactions)
- Final output showing updated balances

## How to Run

1. Clone or download the project
2. Make sure the `data/` folder contains:
   - `accounts.txt`
   - `transactions.txt`
3. Open the project in your IDE
4. Run `Main.java`

No external dependencies are required.