variable "instance_name" {
  description = "The name of the compute instance"
  type        = string
}

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

resource "google_compute_instance" "app" {
  name         = var.instance_name
  machine_type = var.machine_type
  zone         = var.zone

  boot_disk {
    initialize_params {
      image = "debian-cloud/debian-11"
    }
  }

  network_interface {
    subnetwork = var.subnet_id
    access_config {
      // Ephemeral public IP
    }
  }

  tags = ["http-server", "ssh-server"]

  metadata_startup_script = "echo 'Hello, World!' > /var/www/html/index.html"
}

output "instance_ip" {
  value = google_compute_instance.app.network_interface[0].access_config[0].nat_ip
}
