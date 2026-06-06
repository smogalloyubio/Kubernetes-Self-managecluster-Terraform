variable "project_id" {
  description = "The GCP project ID"
  type        = string
}

variable "region" {
  description = "The GCP region"
  type        = string
  default     = "us-central1"
}

variable "zone" {
  description = "The GCP zone"
  type        = string
  default     = "us-central1-a"
}

variable "network_name" {
  description = "The name of the VPC network"
  type        = string
  default     = "library-vpc"
}

variable "subnet_cidr" {
  description = "The CIDR block for the subnetwork"
  type        = string
  default     = "10.0.1.0/24"
}

variable "machine_type" {
  description = "The machine type for the instances"
  type        = string
  default     = "e2-medium"
}

variable "k8s_master" {
  description = "Name prefix of the master node"
  type        = string
  default     = "master-node"
}

variable "k8s_worker" {
  description = "Name prefix of the worker node"
  type        = string
  default     = "worker-node"
}
