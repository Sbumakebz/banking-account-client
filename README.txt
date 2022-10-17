Limitations of solution:
1. Transfers cannot be done from Savings to Cheque account or vise-versa
2. No authentification has been implemented 
3. No security implementation has been done such as encrypting account details
4. actuators not implemented
5. No UI has been implemented

Banking-account-service - Service Registry
Banking-account-client - Client GateWay which also routes according to request
Savings-account-client - Savings Account application
Cheque-account-client - Cheque Account application

Steps to test:
1. Run Banking-account-service with spring boot run command
2. Run Savings-account-client and Cheque-account-client using spring boot run command
3. Run Banking-account-client for the testing
