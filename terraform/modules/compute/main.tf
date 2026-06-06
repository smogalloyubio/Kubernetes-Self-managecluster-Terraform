resource "google_compute_instance" "sonarqube" {
  name         = "sonarqube-server"
  machine_type = var.machine_type
  zone         = var.zone

  boot_disk {
    initialize_params {
      image = "ubuntu-os-cloud/ubuntu-2204-lts"
      size  = 30 
    }
  }

  network_interface {
    subnetwork = var.subnet_id
    access_config {}
  }
}

resource "google_compute_instance" "k8s_master" {
  name         = "${var.k8s_master}-machine"
  machine_type = var.machine_type
  zone         = var.zone

  boot_disk {
    initialize_params {
      image = "ubuntu-os-cloud/ubuntu-2204-lts"
    }
  }

  network_interface {
    subnetwork = var.subnet_id
    access_config {}
  }
}

resource "google_compute_instance" "k8s_worker" {
  name         = "${var.k8s_worker}-machine"
  machine_type = var.machine_type
  zone         = var.zone

  boot_disk {
    initialize_params {
      image = "ubuntu-os-cloud/ubuntu-2204-lts"
    }
  }

  network_interface {
    subnetwork = var.subnet_id
    access_config {}
  }
}

output "sonarqube_ip" {
  value = google_compute_instance.sonarqube.network_interface[0].access_config[0].nat_ip
}

output "k8s_master_ip" {
  value = google_compute_instance.k8s_master.network_interface[0].access_config[0].nat_ip
}

output "k8s_worker_ip" {
  value = google_compute_instance.k8s_worker.network_interface[0].access_config[0].nat_ip
}
