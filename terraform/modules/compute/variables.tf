variable "machine_type" {
  description = "The machine type for the instance"
  type        = string
}

variable "zone" {
  description = "The zone for the instance"
  type        = string
}

variable "subnet_id" {
  description = "The subnetwork ID to launch in"
  type        = string
}

variable "k8s_master" {
  description = "Name prefix of the master node"
  type        = string
}

variable "k8s_worker" {
  description = "Name prefix of the worker node"
  type        = string
}
