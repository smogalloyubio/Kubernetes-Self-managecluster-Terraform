provider "google" {
  project = var.project_id
  region  = var.region
}

module "network" {
  source       = "./modules/network"
  network_name = var.network_name
  subnet_cidr  = var.subnet_cidr
  region       = var.region
}

module "compute" {
  source       = "./modules/compute"
  machine_type = var.machine_type
  zone         = var.zone
  subnet_id    = module.network.subnet_id
  k8s_master   = var.k8s_master
  k8s_worker   = var.k8s_worker
}

module "firewall" {
  source       = "./modules/firewall"
  network_name = module.network.network_name
  subnet_cidr  = var.subnet_cidr
}
