output "network_name" {
  value = module.network.network_name
}

output "subnet_id" {
  value = module.network.subnet_id
}

output "instance_external_ip" {
  value = module.compute.instance_ip
}
