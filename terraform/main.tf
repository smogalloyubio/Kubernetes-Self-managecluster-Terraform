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
  source        = "./modules/compute"
  instance_name = var.instance_name
  machine_type  = var.machine_type
  zone          = var.zone
  subnet_id     = module.network.subnet_id
}
