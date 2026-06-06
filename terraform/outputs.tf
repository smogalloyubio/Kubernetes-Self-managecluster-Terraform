output "network_name" {
  value = module.network.network_name
}

output "subnet_id" {
  value = module.network.subnet_id
}

output "sonarqube_public_ip" {
  value = module.compute.sonarqube_ip
}

output "k8s_master_public_ip" {
  value = module.compute.k8s_master_ip
}

output "k8s_worker_public_ip" {
  value = module.compute.k8s_worker_ip
}
