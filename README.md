
# 🚀 CloudForge Platform: Self-Managed Kubernetes Cluster Automation with Terraform, DevSecOps CI/CD and GitOps Deployment


![Terraform](https://img.shields.io/badge/Terraform-Infrastructure_as_Code-844FBA?logo=terraform)
![Google Cloud](https://img.shields.io/badge/Google_Cloud-Compute_Engine-4285F4?logo=googlecloud)
![Kubernetes](https://img.shields.io/badge/Kubernetes-Orchestration-326CE5?logo=kubernetes)
![Kubeadm](https://img.shields.io/badge/Kubeadm-Kubernetes_Installation-326CE5?logo=kubernetes)
![Docker](https://img.shields.io/badge/Docker-Containerization-2496ED?logo=docker)
![GitHub Actions](https://img.shields.io/badge/GitHub_Actions-CI%2FCD-2088FF?logo=githubactions)
![ArgoCD](https://img.shields.io/badge/ArgoCD-GitOps-orange?logo=argo)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-Backend-6DB33F?logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?logo=mysql)
![Trivy](https://img.shields.io/badge/Trivy-Security_Scanning-blue)
![SonarQube](https://img.shields.io/badge/SonarQube-Code_Quality-F3702A?logo=sonarqube)
![Checkov](https://img.shields.io/badge/Checkov-IaC_Security-green)
![SBOM](https://img.shields.io/badge/SBOM-Software_Supply_Chain_Security-purple)


# Overview

The **CloudForge Platform** is an end-to-end Cloud Engineering and DevOps automation project that demonstrates how to design, provision, secure, deploy, and manage a self-managed Kubernetes environment on Google Cloud.

The project implements a complete cloud-native application delivery lifecycle by combining:

* Infrastructure as Code (IaC)
* Self-managed Kubernetes administration
* Container orchestration
* CI/CD automation
* DevSecOps security practices
* GitOps continuous delivery


Unlike managed Kubernetes services such as GKE, this project demonstrates how to manually build and operate a Kubernetes cluster from the ground up using industry-standard Kubernetes administration tools.

The infrastructure is provisioned using **Terraform**, which creates three Google Compute Engine virtual machines that form the Kubernetes cluster environment.

The Kubernetes cluster is then installed manually using:

* kubeadm
* kubelet
* kubectl


The cluster architecture consists of:

* One Kubernetes control plane node.
* Two Kubernetes worker nodes.


After cluster provisioning, **Argo CD** is installed to provide GitOps-based application deployment.

The application delivery pipeline is automated using **GitHub Actions**, which performs:

* Source code checkout.
* Application testing.
* Infrastructure security scanning.
* Container security scanning.
* Code quality analysis.
* Software Bill of Materials generation.
* Docker image creation.
* Docker image publishing.


The application deployed on the Kubernetes cluster follows a three-tier architecture:

```
                User

                 |

                 |

          Frontend Layer

                 |

                 |

        Spring Boot Backend API

                 |

                 |

            MySQL Database

```


The CI/CD pipeline builds the application container image, pushes it to Docker Hub, and updates the Kubernetes deployment configuration.

Production deployment is managed using **Argo CD**, which connects the Git repository with the Kubernetes cluster and continuously synchronizes the desired application state.


This project represents a real-world Cloud Engineering workflow demonstrating:

* Cloud infrastructure automation.
* Kubernetes cluster administration.
* Secure CI/CD implementation.
* Container lifecycle management.
* GitOps deployment practices.


---

# Business Value

Modern engineering teams face several challenges when building and managing Kubernetes platforms.

| Challenge | Impact |
|-----------|--------|
| Manual infrastructure creation | Slow environment provisioning |
| Managed Kubernetes dependency | Limited understanding of Kubernetes internals |
| Manual cluster installation | Configuration inconsistencies |
| Manual application deployment | Human errors and slow releases |
| Security testing after deployment | Increased security risks |
| Lack of deployment automation | Slow software delivery |
| Configuration drift | Environment instability |
| No GitOps workflow | Difficult rollback and auditing |


This platform solves these challenges by providing:


* Automated cloud infrastructure provisioning using Terraform.
* Self-managed Kubernetes cluster deployment.
* Infrastructure version control.
* Secure DevSecOps CI/CD pipeline.
* Automated Docker image creation.
* Kubernetes workload deployment.
* GitOps-based production delivery using Argo CD.
* Complete deployment traceability through Git history.


---

# Problem & Solution


| Problem | Solution |
|---------|----------|
| Manual VM creation | Terraform provisions Google Compute Engine resources |
| Manual Kubernetes installation | kubeadm automates cluster initialization |
| No infrastructure consistency | Infrastructure defined as code |
| Manual Docker builds | GitHub Actions automates image creation |
| Security checks performed manually | DevSecOps tools integrated into pipeline |
| Vulnerable container images | Trivy scans images before deployment |
| Poor code quality visibility | SonarQube performs static analysis |
| Unknown software dependencies | SBOM generation provides visibility |
| Manual Kubernetes deployment | Argo CD manages application delivery |
| Production configuration drift | Git repository acts as source of truth |


---

# Architecture Overview


The platform consists of five major layers:


## 1. Infrastructure Layer

Terraform manages the cloud infrastructure lifecycle.


The infrastructure consists of:


* Google Cloud Platform project.
* Three Compute Engine virtual machines.
* Network configuration.
* Firewall rules.
* Kubernetes node infrastructure.


Terraform provides:

* Repeatable infrastructure deployment.
* Version-controlled infrastructure changes.
* Automated environment creation.


---

## 2. Kubernetes Cluster Layer


The Kubernetes cluster is self-managed using:


* kubeadm
* kubelet
* kubectl


The cluster consists of:


```
                 Kubernetes Cluster


              Control Plane Node

                      |

        ------------------------------

        |                            |

        v                            v


   Worker Node                 Worker Node

```


The control plane manages:

* API Server.
* Scheduler.
* Controller Manager.
* etcd.


Worker nodes run:

* Application containers.
* Kubernetes workloads.
* Database services.


---

## 3. Application Layer


The project deploys a three-tier application architecture.


Architecture:


```
                Client

                  |

                  |

             Application Layer

                  |

                  |

        Spring Boot Backend API

                  |

                  |

             MySQL Database

```


Components:


### Spring Boot Backend

Responsible for:

* REST API services.
* Business logic.
* Application communication.


### MySQL Database

Responsible for:

* Persistent application data.
* Database storage.
* Backend data management.


---

## 4. CI/CD Pipeline Layer


GitHub Actions automates the complete software delivery lifecycle.


The pipeline performs:


* Application testing.
* Security scanning.
* Code quality analysis.
* Docker image build.
* Image publishing.
* Deployment automation.


---

## 5. GitOps Deployment Layer


Argo CD manages Kubernetes application delivery.


Argo CD provides:


* Git-based deployment management.
* Automated synchronization.
* Deployment history.
* Rollback capability.


---
