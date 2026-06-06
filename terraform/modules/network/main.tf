variable "network_name" {
  description = "The name of the VPC network"
  type        = string
}

variable "subnet_cidr" {
  description = "The CIDR block for the subnetwork"
  type        = string
}

variable "region" {
  description = "The region for the subnetwork"
  type        = string
}

resource "google_compute_network" "vpc" {
  name                    = var.network_name
  auto_create_subnetworks = false
}

resource "google_compute_subnetwork" "subnet" {
  name          = "${var.network_name}-subnet"
  ip_cidr_range = var.subnet_cidr
  region        = var.region
  network       = google_compute_network.vpc.id
}

resource "google_compute_firewall" "allow_http_ssh" {
  name    = "allow-http-ssh"
  network = google_compute_network.vpc.name

  allow {
    protocol = "tcp"
    ports    = ["80", "22", "8080"]
  }

  source_ranges = ["0.0.0.0/0"]
}

output "network_id" {
  value = google_compute_network.vpc.id
}

output "subnet_id" {
  value = google_compute_subnetwork.subnet.id
}

output "network_name" {
  value = google_compute_network.vpc.name
}
