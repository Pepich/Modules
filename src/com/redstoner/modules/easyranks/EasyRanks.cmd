command promote {
	[string:user] [optional:-k] {
		run promote user -k
		help Promotes a user.
		perm utils.easyranks.promote
	}
}

command demote {
	[string:user] [optional:-k] {
		run demote user -k
		help Demotes a user.
		perm utils.easyranks.demote
	}
}

command retire {
	[string:user] [optional:-k] {
		run retire user -k
		help Retires a user.
		perm utils.easyranks.retire
	}
}

command donated {
	[optional:alot] [string:user] [optional:-k] {
		run donated user alot -k
		help Adds a user to the Donator(+) group.
		perm utils.easyranks.donated
	}
}

command dev {
	[string:user] [optional:-k] {
		run dev user -k
		help Adds a user to the Developer group.
		perm utils.easyranks.dev
	}
}

command alt {
	[string:user] [optional:-k] {
		run alt user -k
		help Adds user to the Alternate Account group.
		perm utils.easyranks.alt
	}
}

command lead {
	[string:user] [optional:-k] {
		run lead user -k
		help Adds user to the Lead group.
		perm utils.easyranks.lead
	}
}

command nowe {
	[string:user] [optional:-k] {
		run nowe user -k
		help Disallows World Edit for a user.
		perm utils.easyranks.nowe
	}
	
	[string:user] [int:weeks] [optional:-k] {
		run nowet user weeks -k
		help Disallows World Edit for a user.
		perm utils.easyranks.nowe
	}
}

command no_sv {
	[string:user] [optional:-k] {
		run no_sv user -k
		help Disallows a user to use the Survival World.
		perm utils.easyranks.no_sv
	}
	
	[string:user] [int:weeks] [optional:-k] {
		run no_svt user weeks -k
		help Disallows a user to use the Survival World.
		perm utils.easyranks.no_sv
	}
}

command no_tsv {
	[string:user] [optional:-k] {
		run no_tsv user -k
		help Disallows a user to use the Trusted Survival World.
		perm utils.easyranks.no_tsv
	}
	
	[string:user] [int:weeks] [optional:-k] {
		run no_tsvt user weeks -k
		help Disallows a user to use the Trusted Survival World.
		perm utils.easyranks.no_tsv
	}
}
