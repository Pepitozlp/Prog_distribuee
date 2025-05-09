# Distributed Programming Project

This project is an implementation of a rental service. This guide will explain how to clone and install this repository.

## Installation

### Prerequisites
- Docker
- Minikube
- Kubectl
- A terminal or command-line tool

### Setup Steps

1. **Start Minikube**
    Start Minikube
    ```bash
    minikube start --driver=docker
    ```

2. **Clone the repository**
    ```bash
    git clone https://github.com/Pepitozlp/Prog_distribuee
    ```
    ```bash
    cd Prog_distribuee
    ```

3. **Apply deployment**
    ```bash
    kubectl apply -f deployment.yml
    ```

4. **Launch the site**
    ```bash
    minikube service front-end-service --url 
    ```
    this will give you an ip adress to access the site

    to access the front you will need to entrer
    ```
    ip-address-given-to-you/frontend/...
    ```
    where the ... can be replaced by :  ```Cars ``` or  ```motos ```
    after that you can add  ```/i ``` where i is the id of the car or moto 

5. **Images**


    the docker images can be found on https://hub.docker.com/repositories/pepitozlp and are called : ```rent``` and ```frontrent```