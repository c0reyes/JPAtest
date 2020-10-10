# JPAtest example

Example for test JPA with connection to MySQL.

To testing the [Environment develop](https://github.com/c0reyes/envdev).

## Clone Repository

Clone to your machine, if you want or use the repository from GitHub. Create new repository on Gitea.

```
git clone https://github.com/c0reyes/jpatest.git
```

Change remote url to local Gitea.

```
git remote remove origin
git remote set-url origin http://localhost:3000/git/jpatest.git
git push
```

## Configure Pipeline

- **Open browser:** Go to http://localhost:8080/
- **Jenkins:** Open Blue Ocean
    - New Pipeline
    - Select Git
    - Write repository url and Create pipline

## Kubernetes Credentials

- Generate kubeconfig

```
kubectl config view --flatten > kubeconfig.txt
```

Modify the server line to: server: https://kubernetes:8443

- Configure credentials
    - Go to Jenkins pipeline project -> Credentials
    - Add Credentials
        - **Kind:** Secret file
        - **File:** (upload kubeconfig.txt file)
        - **ID:** kubeconfig
        - **Description:** optional

## Test

- **/etc/hosts:** Add the line "127.0.0.1 jpatest.info"
- **Open browser:** Go to http://jpatest.info:8000/v1/car/brand
- **Other request in the file test.http**
